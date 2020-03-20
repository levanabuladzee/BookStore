<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
</header>

<main>
    <table>
        <tr>
            <th>Book Name</th>
            <th>Author</th>
            <th>Category</th>
            <th>Pages</th>
            <th>Date</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.category}</td>
            <td>${book.pages}</td>
            <td>${book.year}</td>
            <td>${book.price}$</td>
            <td>
                <form action="add-to-cart" method="post">
                    <input name="bookId" type="hidden" value="${book.id}">
                    <input name="cart" type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
</main>
</body>
</html>
