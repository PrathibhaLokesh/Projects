document.getElementById("vibration").addEventListener("click",vibration);
document.getElementById("vibrationPattern").addEventListener("click",vibrationPattern)
function vibration()
{
    alert("Your Phone will vibrate now");
    var time=3000; 
    navigator.vibrate(time);
}

function vibrationPattern()
{
    alert("Hii about to viberate in pattern");
    var pattern=[1000,2000,3000,1000,5000];
    navigator.vibrate(pattern)
}