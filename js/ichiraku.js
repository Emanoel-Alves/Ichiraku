function entrar(){

    var senha = document.getElementById("senha").value;

        if( document.forms[0].email.value==""
        || document.forms[0].email.value.indexOf('@')==-1 
        || document.forms[0].email.value.indexOf('.')==-1 
        || senha.length < 8) 
        { 

                 alert( "Por favor, informe um E-MAIL válido ou uma senha!" ); 

        }
        
        else {
            document.getElementById("logar").onclick = function () {
            location.href = "file:///C:/Users/srtal/OneDrive/%C3%81rea%20de%20Trabalho/UFC%202020.1/Desenvolvimento%20WEB/Ichiraku-master/Ichiraku-master/pages/home.html";
        
            
        }

        

}


};
