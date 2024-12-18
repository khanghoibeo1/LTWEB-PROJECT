<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
    <!-- Add your CSS styles or link to an external stylesheet here -->
     <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 600px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="number"],
        textarea,
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="file"] {
            margin-top: 5px;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>Edit Product</h2>

    <form action="updateProduct" method="post" enctype="multipart/form-data">
        <!-- Name -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>

        <!-- Brand -->
        <label for="brand">Brand:</label>
        <input type="text" id="brand" name="brand" required>
        <br>

        <!-- Price -->
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" required>
        <br>

        <!-- Image -->
        <label for="image">Image:</label>
        <input type="file" id="image" name="image" accept="image/*">
        <br>

        <!-- Description -->
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea>
        <br>

        <!-- Status -->
        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="active">Active</option>
            <option value="inactive">Inactive</option>
        </select>
        <br>

        <!-- Category -->
        <label for="category">Category:</label>
        <select id="category" name="category" required>
            <option value="category1">Category 1</option>
            <option value="category2">Category 2</option>
            <!-- Add more options as needed -->
        </select>
        <br>

        <button type="submit">Save Changes</button>
    </form>

    <!-- Add your JavaScript scripts or link to external scripts here -->

</body>
</html>
