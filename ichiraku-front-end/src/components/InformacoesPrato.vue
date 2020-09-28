<template>
   <div class="ConteineInfo">
    
    <Menu/>

      <section class="InfoPrato">
        <div class="volta">
          <a href="../pages/opcoesDoDia.html"> Voltar </a>
        </div>

        <div class="CardapioPratos">
          <a href="../pages/opcoesDoDia.html">
            <div class="box"><p>Sushi e sashimis</p></div></a
          >

          <a href="../pages/opcoesDoDia.html">
            <div class="box"><p>Pratos quentes</p></div></a
          >
          

          <a href="../pages/opcoesDoDia.html">
            <div class="box"><p>Sobremesas</p></div>
            ></a
          >
        </div>

        <div class="OpcaoPratos">
          <div class="Pratos">
            <img src="../assets/img1.png" alt="Prato" />

            <div>
              <h2>Sushi</h2>

              <div class="ingredientes">
                <h4>Ingredientes</h4>

                <p>
                  arroz japonês, tempero à base de peixe bonito, cenoura, vagem,
                  Gengibre, algas, salmão, vinagre de arroz.
                </p>
              </div>

              <h3>R$ 25,00</h3>

              <a href=""> Peça delivery </a>
            </div>
          </div>
        </div>
      </section>
    </div>
</template>

<script>
import Menu from "@/components/Menu.vue";

export default {
name: "InfoPrato",
  components: {
      Menu,
  },
};
</script>

<style>

.ConteineInfo{

    width: 100%;
    display: flex;
    justify-content: center;
    align-content: center;
}

.InfoPrato{
    width: calc(100% - 290px);
    height:auto;
    display: flex;
    flex-direction: column;
   
    background-color: #EBEBEB;
    color: black;
}

.InfoPrato .CardapioPratos {

    width: 80%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    height: auto;
    margin: 5px auto;
}



.InfoPrato .CardapioPratos a {
    width: 220px ;
    height: 35px;
    position: relative;
    text-decoration: none;
}

.InfoPrato .CardapioPratos .box {

    width: 220px ;
    height: 35px;
    background-color: white;
    text-align: center;
    position: absolute;
    color: black;
    transition: background-color 0.9s ;
    border-radius: 4px;
}

.InfoPrato .CardapioPratos .box p{ 

    margin: 10px;

}

.InfoPrato .CardapioPratos .box:hover {
    background-color: #403939;
    color: white;
}

.InfoPrato .OpcaoPratos {

    width: 80%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
    height: auto;
    margin: 10px auto;
    margin-bottom: 30px;

}


.InfoPrato .OpcaoPratos .Pratos{
    width: 100%;
    height: 400px;
    margin: 10px 0;
    display: flex;
    justify-content: space-around;
    border-radius: 8px;
    background-color: white;
}

.InfoPrato .Pratos div {
    width: 50%;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
    
}
.InfoPrato .Pratos img {
    width: 260px;
    height: 350px;
    margin:  auto;
    
}

.InfoPrato .Pratos div h2{
    font-size: 30px;
    margin: 0;
}

.InfoPrato .Pratos div h3{
    font-size: 30px;
    color: #b40707;
    margin: 0;
}

.InfoPrato .Pratos div .ingredientes{
    width: 300px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;

}
.InfoPrato .Pratos div .ingredientes h4{
    margin: 0;
}

.InfoPrato .Pratos div a {
    width: 180px;
    border-radius: 8px;
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

.InfoPrato .Pratos div a:hover {

    background-color: #b40707;
    border: 0.7px solid #b40707;

}

.volta {

    margin: 20px 35px;
}


.volta a{
    width: 135px;
    border-radius: 8px;
    background-color: #F42D2D;
    border: 0.7px solid #EC1B1B;
    color: white;
    margin: 8px 0;
    appearance: button;
    text-align: center;
    text-decoration: none;
    padding: 5px 0;
    transition: background-color 0.5s;
    
}

.volta a:hover {

    background-color: #b40707;
    border: 0.7px solid #b40707;

}

</style>