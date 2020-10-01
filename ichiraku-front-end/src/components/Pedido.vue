<template>
 <div class="Conteine">
   <Menu/>

    <section>
        <div class="Info">
          <h1>Acompanhar  meu  pedido</h1>
        </div>

          <div class="Status">

              <h1>Status:</h1>
              <h3>Pedido confirmado</h3>

          </div>

        <div class="StatusPratos">

            <h2>Itens comprados:</h2>
    
        </div>


    </section>

</div>
</template>

<script>
import Menu from "@/components/Menu.vue";
export default {
name: "Pedido",
  components: {
    Menu,
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

.StatusPratos h2 {

   text-align: left;
   margin: 12px 15px;
   font-size: 18px;
   color: gray;
}
</style>