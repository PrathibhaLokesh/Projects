<?php
    $username=$_POST['uname'];
    $password=$_POST['pass'];
    $emailid=$_POST['email'];
    $phno=$_POST['no'];
    $conn=new mysqli("localhost","root","");
    mysqli_select_db($conn,"project");
    $s=select * from signup where username='$username');
    $result=mysqli_query($conn,$insert);
    $num=mysqli_num_rows($result);
    if($num==1)
    {
echo "User already taken";
    }
    else
    {
        $insert="insert into signup(username,password,emailid,phno) values('$username','$password','$emailid','$phno')";
        mysqli_query($conn,$reg);
        echo "Registration Sucessfull";
    }
?>