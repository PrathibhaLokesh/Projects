<?php
include('Config.php');
	$user=$_POST['uname'];
	$pass=$_POST['password'];

$sql="insert into loginform(User,Pass) values('$user','$pass');";
	if(mysqli_query($con, $sql))
	{
		echo "Successfully Addedd";
	}
	else
	{
		echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
	}
?>