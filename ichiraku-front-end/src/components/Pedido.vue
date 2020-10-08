<template>
 <div class="Conteine">
   <Menu/>

    <section>
        <div class="Info">
          <h1>Acompanhar  meu  pedido</h1>
        </div>

          <!-- <div class="Status">

              <h1>Status:</h1>
              <h3>Pedido confirmado</h3>

          </div> -->

        <div class="StatusPratos">

            <h2>Itens comprados:</h2>

            <div class="Pedido" v-for="pedido in pedidos" :key="pedido.id" >

              <p > Prato: {{pedido.nome}} </p>

              <p > Valor: R$ {{ pedido.preco }}</p>

            </div>
                   <!-- <h4>Valor total: {{soma}} </h4> -->

        </div>

    </section>

</div>
</template>

<script>
import Menu from "@/components/Menu.vue";
export default {
name: "Pedido",

data() {
    return {
      soma: 0,
      pedidos: [],
      baseURI: "http://localhost:8080/ichiraku-back-and/api/pedidos",
    };
  },

  components: {
    Menu,
  },
  methods: {

   getPedidos() {
         this.$http.get(this.baseURI).then((result) => {
         this.pedidos = result.data;
        });
     },

     somar(){

       for(pedido in this.pedidos){

         this.soma += pedido.preco;
   
       }
      console.log(this.soma)
     }
  },
  mounted() {
    this.getPedidos();
    this.somar();
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
    font-size: 21px;
}

.Status {
   width: 80%;
   display: flex;
   height: auto;
   margin: 10px auto;
   margin-bottom: 30px;
    
}

.Status h3 {
  font-size: 33px;
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

.StatusPratos h2 {

   text-align: left;
   margin: 12px 15px;
   font-size: 18px;
   color: gray;
}

.StatusPratos h4 {

   text-align: right;
   margin: 12px 15px;
   color: #840705;
}

.StatusPratos .Pedido {

  display: flex;
}

.StatusPratos .Pedido p{

  margin: 12px 25px;
  font-size: 21px;
  color: black;

}


</style>