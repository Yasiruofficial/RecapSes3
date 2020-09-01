<html>
<head>
    <title>Online Book Store</title>
    <style>
        input.btn{
            background-color: deeppink;
            width: 50%;
            height: 50px;
            color: white;
            font-size: 15px;
            float: right;
            border-radius: 5px;
        }
        input.txt{
            border-color: black;
            border-width: 0;
            border-bottom-width: 1px;

        }
        h1{
            margin-top: 80px;
        }

    </style>
</head>
<body>
    <form action="Book/addToCart" method="post">
        <h1 align="center"><span style="color: deeppink">MY CART</span></h1>
        <br>
        <table align="center" cellspacing="10" cellpadding="10">
            <tr>
                <td>NAME</td>
                <td><input type="text" name="Name" class="txt"></td>
            </tr>
            <tr>
                <td>AUTHOR</td>
                <td><input type="text" name="author" class="txt"></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="qty" class="txt"></td>
            </tr>
                <td colspan="2"><input type="submit" name="submit" value="ADD TO CART" class="btn"></td>
            </tr>
        </table>
    </form>
</body>
</html>
