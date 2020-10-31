<template>
   <div class="Conteine">
   <Menu/>

        <section>
            <div class="Info">
            <h1>Lista de pedidos </h1>
            </div>

         <div class="StatusPratos">

            <div class="titulo">        
                <h4 class="prato"> Prato  </h4>
                <h4 > Valor </h4>

            </div>

            <div class="Pedido" v-for="cesta in cestas " :key="cesta.id" > 

                <img :src="'../uploads/produtos/' + cesta.idPrato + '.png'" alt="" />

                <div class="nomePrato">
                  <p > {{cesta.nomePrato}}</p>
                  <p class="preco">{{cesta.valorPrato}}</p>
               </div>
                <a
                @click="deleteCesta(cesta.id)"
                class="btn btn-danger button-delete"
                role="button"
                aria-disabled="true"
                ><i class="far fa-trash-alt"></i
              ></a>

            </div>     

        </div>

        <div class="butão">

            <h5>Agradecemos a preferência </h5>

            <!-- <a href="">Finalizar comprar</a> -->

            <input
                @click="postPedido()"
                value="Finalizar comprar"
                class="add_cesta"
                type="button"
                id="button_adc"
            />
            
       </div>

    </section>

   </div>
</template>

<script>
import Menu from "@/components/Menu.vue";
export default {
name: "Cesta",

data() {
    return {
      soma: 0,
      idUsuario: "",
      cestas: [],
      pedido:{},
      baseURI: "http://localhost:8080/api/cesta",
      baseURIPedido: "http://localhost:8080/api/pedidos"
    };
  },

  components: {
    Menu,
  },
  methods: {

   getCesta() {    
      this.usuario = JSON.parse(this.$session.get("usuario"));
      this.idUsuario = this.usuario[0].id;

         this.$http.get(this.baseURI + "/searchUser?idUsuario=" + this.idUsuario ).then((result) => {
         this.cestas = result.data;
        });
     },

    postPedido() {
      this.usuario = JSON.parse(this.$session.get("usuario"));
      this.idUsuario = this.usuario[0].id;

      this.pedido.idUser = this.idUsuario;
      this.pedido.nome = "";
      this.pedido.valorTotal = 0;

      this.cestas.forEach(element => {
        this.pedido.nome += element.nomePrato + " - "; //concatena os nomes dos pratos
        this.pedido.valorTotal = Number(element.valorPrato) + Number(this.pedido.valorTotal) // faz a soma total
      });
      this.pedido.nome =  this.pedido.nome.slice(0, this.pedido.nome.length - 2) //remove o ultimo traço
      console.log(this.pedido);
      
      this.$http.post(this.baseURIPedido, this.pedido).then((result) => {
        this.$router.push("/pedido");
      });

      this.cestas.forEach(element => {
        this.deleteCesta(element.id); //remove todo mundo da cesta depois de adicionar no carrinho, muitas chamadas na api, mas fe em deus
        
      });
       
    },

    deleteCesta(id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        this.cestas = this.getCesta();
      });
    },

  }, 
  mounted() {
    this.getCesta();
  },
}
</script>

<style scoped>
html,
body {
  margin: 0;
  padding: 0;
  width: 100%;
  font-family: "Roboto", sans-serif;
}

.Conteine {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-content: center;
}

section {
  width: calc(100% - 290px);
    height:100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #EBEBEB;
    color: black;
    overflow: auto;
}

.Info {
    width: 80%;
    height: auto;
    margin: 30px auto;
    color: #840705;
    font-size: 23px;
}

.Info h1 {
      font-size: 38px;
}

.Status {
   width: 80%;
   display: flex;
   height: auto;
   margin: 10px auto;
   margin-bottom: 30px;
    
}
.Status h3 {

    color: #DC2F02;
    margin: auto 15px;
}

.StatusPratos {

    width: 80%;
    flex-direction: column;
    justify-content: space-evenly;
    height: auto;
    margin: 10px auto;
    margin-bottom: 30px;
    background: white;

}
.titulo{

    width: 80%;
    display: flex;
    justify-content: space-around;
    height: auto;
    margin: 10px auto;
    margin-left: 0;
    margin-bottom: 30px;
    background: white;

}

.titulo .prato {

  margin-left: 15px;
}

.Pedido{

    width: 85%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    height: auto;
    margin: 10px auto;
    margin-bottom: 30px;
    background: white;

}

.Pedido img {

  width: 80px;
  height: 80px;
}

.nomePrato {

  display: flex;
}

.nomePrato p{
  text-align: left;
  width: 150px;
}

.nomePrato .preco {
  margin-left: 55px;
  width: 70px;
}

.butão {
    width: 80%;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.butão  .add_cesta {
    width: 260px;
    border-radius: 3px;
    background-color: #F42D2D;
    border: 0.7px solid #EC1B1B;
    color: white;
    margin: 8px 0;
    margin-bottom: 25px;
    appearance: button;
    text-align: center;
    text-decoration: none;
    padding: 5px 0;
    transition: background-color 0.5s;
    
}

 .butão  .add_cesta:hover {

    background-color: #b40707;
    border: 0.7px solid #b40707;

}

.button-delete {
  width: 50px;
  height: 28px;
  padding: 3px;
  color: #fff;
  background-color: #ec1b1b;
  margin: 5px;
}
</style>