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
        <div>
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
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${requestScope.carts}" var="cart">
            <tr>
                <td>${cart.bookName}</td>
                <td>${cart.bookAuthor}</td>
                <td>${cart.bookPrice}$</td>
                <td>
                    <form action="remove-from-cart" method="post">
                        <input name="cartId" type="hidden" value="${cart.cartId}">
                        <input name="cart" type="submit" value="Remove from Cart">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</main>
</body>
</html>
