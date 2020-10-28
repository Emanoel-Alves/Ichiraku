<template>
  <div class = "cadastro">
            <form>
                <div class="esquerda">
                <label>E-mail*</label><br>
                <input id = "email" type = "text" name = "email" placeholder="exemplo@email.com" required> <br>
                <label>Senha*</label><br>
                <input id = "senha" type = "password" name = "senha" placeholder="password" required><br>
                <label>Confirmar senha*</label><br>
                <input id = "confirmar" type = "password" name = "confirmar" placeholder="password" required> <br><br>
                </div>
                <button type="button" @click="cadastrar" id = "cad">Cadastrar</button><br><br>

                <div class = "direita">
                    <h6>Já é cadastrado?</h6>
                <a href = "/login">Logar</a>
                </div>
                    
                
            </form>
            <div class = "barra">
            <div class = "logo"><img src="../assets/logo1.png" alt="logo" ></div>
        
        </div>
        </div>
        
        
</template>

<script>
export default {
    name: 'cadastrar',
        data(){
        return{
            errors: [],
            email: null,
            senha: null,
            confSenha: null,
            
        };
    },

    methods:{
        cadastrar: function() {
            if(email.value == "" ||
               email.value.indexOf("@") == -1 ||
               email.value.indexOf(".") == -1 ||
               senha.value == "" || senha.value.length < 8){
                    alert("Por favor, revise seu e-mail ou senha!");

               }else{
                   this.$router.replace("cadastrar");
               }             
           
      }

      }


    }


</script>

<style scoped>

body{
    background-color: #DFDFDF;
    
}

.esquerda{
    text-align: left;
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
    height: 450px;
    left: 600px;
    top: 0px;

    background:#C4C4C4;
    border-radius: 30px;
    display: flex;

    

}

.logo{
    position: absolute;
    width: auto;
    height: auto;
    left: 60px;
    top: 100px; 
  
}

input{
    background:#C4C4C4;
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
h6 {
    margin: 10px;
}

</style>