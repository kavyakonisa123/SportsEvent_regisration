<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Home</title>
    <style>
         body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #6495ED ;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            text-align: center;
            padding-top: 50px;
        }

        h1 {
            color: #333;
     
        }

        .register-button {
                  display: inline-block; /* Display button as block element */
            padding: 10px 20px;
            font-size: 1.2em;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none;
            margin-top: 20px; /
        }

        .register-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Hello, welcome To IPL !</h1>
        <div> <!-- New div for button -->
            <a href="register" class="register-button">Register Now</a>
        </div>
    </div>
</body>
</html>
