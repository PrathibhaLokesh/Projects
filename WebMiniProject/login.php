<?php
$host="localhost";
$user="root";
$password="";
$db="demo";

mysqli_connect($host,$user,$password);
mysqli_select_db($db);

if(isset($_post['username']))
{
    $uname=$_post['username'];
    $password=$_post['password'];
    
    $sql="select * from LoginForm where user='".$uname."'AND Pass='".$password."'limit 1";
    $result=mysqli_query($sql);
    if(mysqli_num_rows($result)==1)
    {
        echo"You have Successfully Logged in";
        exit();
    }
    else
    {
        echo"Unsuccessful Login";
        exit();
    }
}
?>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="#">
                <div class="form_input">
                    <input type="text" name="username" placeholder="Enter Your Name"/>
                </div>
                <div class="form_input">
                    <input type="password" name="password" placeholder="Enter Your Password" />
                </div>
                <input type="submit" name="submit" value="LOGIN" class="btn-login" />
            </form>
        </div>
    </body>
</html>