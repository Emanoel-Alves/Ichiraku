<template>
  <div class = "login">
        <form>    
            <div class = "img"><img src="../assets/usuario.png" alt="usuario"></div><br>
            <label>E-mail:</label><br>
            <input id="email" type="text" name="email" placeholder="exemplo@email.com" required /><br>
            <label>Senha:</label><br>
            <input id="senha" type="password" name="senha" placeholder="password" required /> <br><br>
            <button type="button" onclick="entrar()" id = "logar">Entrar</button><br><br>
            <div class = "direita">
                <h5>Não é cadastrado?</h5>
                <a href = "..\ichiraku-front-end\src\components\TelaCadastro.vue">Cadastre-se</a>
            </div> 
        </form>
        
         <div class = "barra">
             <div class = "logo"><img src="../assets/logo1.png" alt="logo"></div>
         </div>
          
 </div>       
</template>

<script>
export default {

    entrar(){
  var senha = document.getElementById("senha").value;

  if (
    document.forms[0].email.value == "" ||
    document.forms[0].email.value.indexOf("@") == -1 ||
    document.forms[0].email.value.indexOf(".") == -1 ||
    senha.length < 8
  ) {
    alert("Por favor, informe um E-MAIL válido ou uma senha!");
  } else {
    document.getElementById("logar").onclick = function () {
      location.href = "C:\Users\srtal\OneDrive\Área de Trabalho\UFC 2020.1\Desenvolvimento WEB\github\Ichiraku\ichiraku-front-end\src\components\Home.vue";
    };
  }
}


}
</script>

<style>

body{
    background-color:lightgray;      
}

h5 {
    margin:10px;
}
.login{
    position: absolute;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 40%;
    height: auto;
    right: 760px;
    top: 100px;
}
.direita{
    width: 300px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: auto;
    left: 120px;
    top: 200px;
    
}

.barra{
    
position: absolute;
width: 6px;
height: 500px;
left: 600px;
top: 1px;

background:gray;
border-radius: 30px;
display: flex;

}

input{
    background:#C4C4C4;
    border-radius: 8px;
    width: 320px;
    height: 30px;
    border: 0;
    margin: 10px 0px ;
    
}

button{
    background: #840705;
    width: 330px;
    height: 30px;
    
    border-radius: 8px;
    color: white;
    border: 0;


}

.img{
width: 80px;
height: 80px;
margin:0  auto;

}
.img img{
width: 90px;
height: 90px;

}

.logo{
    position: absolute;
    width: 100px;
    height: 100px;
    left: 50px;
    top: 150px;    
}









</style>