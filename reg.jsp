<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Regestration</title>
    <link rel="stylesheet" href="css-file/reg.css">

    <style>
        /* Responsive styles for smaller screen */
         @media only screen and (max-width: 600px) {
        body {
             width: 90%; 
        }
    }
    </style>
    
</head>
<body>
    <!-- Heading -->
    <div class="container">
        <h1>Employee Registration</h1>
        <hr>
    </div>

    <!-- main content -->
    <form action="RegisterServlet" method="post">
        <section>
            <p>* required fields.</p>
            <h3 style="text-decoration: underline;">ABOUT: </h3>
            <p>Name:*  <input type="text" name="name" required placeholder="Your fullname..."></p>
            <p>Date of birth:* <input type="date" name="DOB" required></p>
            <p>
                Gender:* <input type="radio" name="gender" value="male">Male
                        <input type="radio" name="gender" value="female">Female
                        <input type="radio" name="gender" value="other">Other
            </p>
        </section>
        <br>
        <section>
            <h3><u>ADDRESS: </u></h3>
            <p>Address:* 
                <textarea name="address" id="address" cols="30" rows="10" required placeholder="Start typing..."></textarea>
            </p>
            <p>City: <input type="text" name="city" id="city" placeholder="Enter your city..."></p>
            <p>State:* <input type="text" name="state" id="state" required></p>
        </section>
        <br>
        <section>
            <h3><u>Login Details</u></h3>
            <p>Username:* <input type="text" name="Username" id="Username"></p>
            <p>Choose Password:* <input type="password" name="Password" id="Password"></p>
            <p>
                <button type="submit">Create Account</button>
                <button type="reset"> Reset</button>
            </p>
        </section>
    </form>
</body>
</html>