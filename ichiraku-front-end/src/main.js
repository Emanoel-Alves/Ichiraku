import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios";
import VueSession from "vue-session";

Vue.config.productionTip = false;
Vue.prototype.$http = axios;
Vue.use(VueSession);

new Vue({
  router,
  render: function (h) {
    return h(App);
  },
}).$mount("#app");
