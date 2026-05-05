<!DOCTYPE html>
<html>
<head>
    <title>URL Shortener</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
            text-align: center;
            width: 400px;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        input {
            width: 90%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }

        button {
            background: #667eea;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background: #5a67d8;
        }
    </style>
</head>

<body>

<div class="container">
    <h2> URL Shortener</h2>

    <form action="shorten" method="post">
        <input type="text" name="url" placeholder="Enter long URL" required><br>
        <input type="text" name="custom" placeholder="Custom short code (optional)"><br>
        <button type="submit">Shorten URL</button>
    </form>
</div>

</body>
</html>