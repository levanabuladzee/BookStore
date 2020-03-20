<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Book Store</title>
</head>
<body>
<header>
    <nav>
        <div class="navbar">
            <ul>
                <li><a href="home">Home</a></li>
                <li><a href="books">Books</a></li>
                <li><a href="cart">Cart</a></li>
                <li><a href="manage">Manage</a></li>
            </ul>
        </div>
    </nav>

    <main>
        <form action="add-book" method="post">
            <label>
                <input type="text" name="bookName" placeholder="Book Name" required>
            </label>
            <label>
                <input type="text" name="author" placeholder="Author" required>
            </label>
            <label>
                <input type="text" name="category" placeholder="Category" required>
            </label>
            <label>
                <input type="text" name="pages" placeholder="Pages" required>
            </label>
            <label>
                <input type="text" name="date" placeholder="Date" required>
            </label>
            <label>
                <input type="text" name="price" placeholder="Price" required>
            </label>
            <input type="submit" name="add" value="Add">
        </form>

        <form action="remove-book" method="post">
            <label>
                <input type="text" name="bookId" placeholder="Book ID" required>
            </label>
            <input type="submit" name="remove" value="Remove">
        </form>
    </main>
</header>
</body>
</html>
