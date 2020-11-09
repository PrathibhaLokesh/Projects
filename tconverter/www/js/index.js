 
function abc()
{
    var x=document.getElementById("id1").value;
    var y=(x-32)/1.8;
    document.getElementById("id2").value=y;
    
        
}
function xyz()
{
    var x=document.getElementById("id2").value;
    var y=(x*1.8)+32;
    document.getElementById("id1").value=y;
    
        
}
function pqr()
{
      document.getElementById("id1").value="";
     document.getElementById("id2").value="";  
}
   
    
    
