<template>
   <div class="Conteine">
   <Menu/>

        <section>
            <div class="Info">
            <h1>Lista de pedidos </h1>
            </div>

         <div class="StatusPratos">

            <div class="titulo">        
                <h4 > Pratos  </h4>
                <h4 > Valor </h4>
                <h4>  Quantidade </h4>
            </div>

            <div class="Pedido" v-for="cesta in cestas" :key="cesta.id" > 

                <p>{{cesta.nome}}</p>
  
                <p>{{cesta.preco}}</p>
            
                <p> </p>

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
      cestas: [],
      inputNome: "",
      inputPreco: null,
      baseURI: "http://localhost:8080/ichiraku-back-and/api/cestas",
      baseURIPedido: "http://localhost:8080/ichiraku-back-and/api/pedidos"
    };
  },

  components: {
    Menu,
  },
  methods: {

   getCesta() {
         this.$http.get(this.baseURI).then((result) => {
         this.cestas = result.data;
        });
     },

    postPedido() {
      this.pedido.nome = this.inputNome;
      this.pedido.preco = Number(this.inputPreco);

      this.$http.post(this.baseURIPedido, this.pedido).then((result) => {
       
        this.deleteCesta();
      });
    },

    deleteCesta(id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        this.cestas = this.getCestas();
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
    margin-bottom: 30px;
    background: white;

}

.Pedido{

    width: 80%;
    display: flex;
    justify-content: space-around;
    height: auto;
    margin: 10px auto;
    margin-bottom: 30px;
    background: white;

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
</style>