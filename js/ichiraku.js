function entrar(){
    document.getElementById("logar").onclick = function () {
        location.href = "file:///C:/Users/srtal/OneDrive/%C3%81rea%20de%20Trabalho/UFC%202020.1/Desenvolvimento%20WEB/Ichiraku-master/Ichiraku-master/pages/home.html";
    }
};

function validar(){ 
    var email = document.getElementById("email");
    var senha = document.getElementById("senha");
      
    if(email == "exemplo@email.com" &&  senha=="11111111"){
      location.href='home.html';
      alert('Tudo certo');
      
    }else{
      alert('Usuario ou senha incorretos');
     
    }
    };