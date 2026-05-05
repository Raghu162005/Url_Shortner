<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f9;
            text-align: center;
            padding-top: 80px;
        }

        .box {
            background: white;
            display: inline-block;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }

        a {
            color: blue;
            font-size: 18px;
        }

        img {
            margin-top: 20px;
        }

        button {
            margin-top: 15px;
            padding: 10px 15px;
            border: none;
            background: #667eea;
            color: white;
            border-radius: 6px;
            cursor: pointer;
        }

        button:hover {
            background: #5a67d8;
        }
    </style>
</head>

<body>

<div class="box">
    <h2>Short URL Created</h2>

    <a href="${shortUrl}" target="_blank">${shortUrl}</a>

    <br><br>

    <button onclick="copyLink()">Copy Link</button>

    <h3>QR Code</h3>
    <img src="${pageContext.request.contextPath}/qr/${code}.png" width="200">

    <br><br>

    <a href="stats?code=${code}">
        <button>View Click Stats</button>
    </a>
</div>

<script>
function copyLink() {
    navigator.clipboard.writeText("${shortUrl}");
    alert("Copied!");
}
</script>

</body>
</html>