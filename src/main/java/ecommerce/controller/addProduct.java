package ecommerce.controller;



import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.common.collect.ImmutableMap;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;
import ecommerce.dao.*;
import ecommerce.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/addProduct"})
@MultipartConfig
public class addProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String downloadUrlImage;
//        PrintWriter out = resp.getWriter();

        String productname = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        Part filePart = req.getPart("image");
        String description = req.getParameter("description");
        String brand = req.getParameter("brand");
        String status = req.getParameter("status");
        String category = req.getParameter("category");
        Category categoryId = null;
        try {
            categoryId = CategoryDAO.getInstance().getCategoryByName(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        InputStream serviceAccount;
        {
            try {
                // Check if FirebaseApp is already initialized
                FirebaseApp app;
                if (FirebaseApp.getApps().isEmpty()) {
                    serviceAccount = getServletContext().getResourceAsStream("/WEB-INF/tunetowntest-e968a-firebase-adminsdk-vu7bk-37fd0625ea.json");
                    FirebaseOptions options = new FirebaseOptions.Builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .setDatabaseUrl("https://tunetowntest-e968a-default-rtdb.asia-southeast1.firebasedatabase.app/")
                            .setStorageBucket("tunetowntest-e968a.appspot.com")
                            .build();
                    app = FirebaseApp.initializeApp(options);
                } else {
                    app = FirebaseApp.getInstance();
                }

                String appCheckToken = Arrays.toString(FirebaseAuth.getInstance(app)
                        .createCustomToken("tunetowntest-e968a")
                        .getBytes());

                // Upload Image to Firebase
                String fileName = filePart.getSubmittedFileName();
                InputStream fileContent = filePart.getInputStream();
                try {
                    Storage storage = StorageClient.getInstance(app).bucket("tunetowntest-e968a.appspot.com").getStorage();

                    BlobInfo blobInfo = BlobInfo.newBuilder("tunetowntest-e968a.appspot.com", "shoes_images/" + fileName)
                            .setContentType(filePart.getContentType())
                            .setMetadata(ImmutableMap.of("firebaseStorageDownloadTokens", appCheckToken))
                            .build();

                    // Upload the file to Firebase Storage
                    storage.create(blobInfo, fileContent,
                            Storage.BlobWriteOption.userProject("tunetowntest-e968a"),
                            Storage.BlobWriteOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ));

                    // Construct the download URL manually
                    downloadUrlImage = "https://firebasestorage.googleapis.com/v0/b/" +
                            "tunetowntest-e968a.appspot.com" +
                            "/o/" +
                            "shoes_images%2F" + fileName +
                            "?alt=media";


                } catch (Exception e) {
                    // Handle any other exception
                    throw new RuntimeException(e);
                } finally {
                    fileContent.close();
                }

//                System.out.println(downloadUrlImage);
                Product product = new Product();
                product.setName(productname);
                product.setBrand(brand);
                product.setCategory(categoryId);
                product.setImage(downloadUrlImage);
                product.setStatus(status);
                product.setPrice(price);
                product.setDescription(description);


                try {
                    ProductDAO.getInstance().addProduct(product);
                    req.setAttribute("message", "Product added successfully");
                } catch (Exception e) {
                    req.setAttribute("message", "Error adding product: " + e.getMessage());
                }
                resp.sendRedirect(req.getContextPath() + "/admin.jsp");


            } catch (FirebaseAuthException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}
