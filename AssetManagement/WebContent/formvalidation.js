
function phone_validation(){
	var telephone = document.getElementById("telephone").value;
	 if(telephone.length !=10)
     {
         document.getElementById("div3").innerHTML="10 Digits Required";
         document.getElementById("div3").style.color="Red";
         
     }

     else
     {
         document.getElementById("div3").innerHTML="";
     }

}


function pwd_validation(){
	var password = document.getElementById("password").value;
	var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	if(password.match(passw))
    {
    	document.getElementById("div6").innerHTML="";
        
    }
    else
    {
    	document.getElementById("div6").innerHTML="Password should contain one Uppercase,one Lowercase,and digits";
        document.getElementById("div6").style.color="Red";
        
    }

}

function repwd_validation()
{
	var password = document.getElementById("password").value;
	var repassword = document.getElementById("repassword").value;
	if(password != repassword)
    {
        document.getElementById("div7").innerHTML="Password not match";
        document.getElementById("div7").style.color="Red";
    }
     else
    {
        document.getElementById("div7").innerHTML="";
    }
}

