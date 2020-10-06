<template>
  <div class = "cadastro">
            <form>
                <label>E-mail*</label><br>
                <input id = "email" type = "text" name = "email" placeholder="exemplo@email.com" required> /><br>
                <label>Senha*</label><br>
                <input id = "senha" type = "password" name = "senha" placeholder="password" required> /><br>
                <label>Confirmar senha*</label><br>
                <input id = "confirmar" type = "password" name = "confirmar" placeholder="password" required> /><br><br>
                <button type="button" onclick="cadastrar()" id = "cad">Cadastrar</button><br><br>

                <div class = "direita">
                    <h4>Já é cadastrado?</h4>
                <a href = "ichiraku.html">Logar</a>
                </div>
                    
                
            </form>
            <div class = "barra">
            <div class = "logo"><img src="../assets/logo1.png" alt="logo" ></div>
        
        </div>
        </div>
        
        
</template>

<script>
export default {

    cadastrar(){

    var senha = document.getElementById("senha").value;

        if( document.forms[0].email.value==""
        || document.forms[0].email.value.indexOf('@')==-1 
        || document.forms[0].email.value.indexOf('.')==-1 
        || senha.length < 8) 
        { 

                 alert( "Por favor, informe um E-MAIL válido ou uma senha!" ); 

        }
        
        else {
            document.getElementById("cad").onclick = function () {
            location.href = "home.html";
        
            
        }

        

}


}

}
</script>

<style scoped>

body{
    background-color: lightgray;
    margin: 0;
    height: 100vh;
}

.cadastro{
    position: absolute;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 40%;
    height: auto;
    right: 760px;
    top: 150px;
    
}

.barra{
    
    position: absolute;
    width: 6px;
    height: 100%;
    left: 685px;
    top: 0;
    
    background:gray;
    border-radius: 30px;
    display: flex;
    

}

.logo{
    position: absolute;
    width: auto;
    height: auto;
    left: 150px;
    top: 215px; 
  
}

input{
    background: #ffffff;
    border-radius: 8px;
    width: 330px;
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

.direita{
    width: 300px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: auto;
    left: 120px;
    top: 200px;
    
}
h4 {
    margin: 10px;
}

</style>