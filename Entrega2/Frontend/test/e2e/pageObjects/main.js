import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/'
import axios from 'axios';

Vue.config.productionTip = false
Vue.prototype.$http = axios;

new Vue({
    el: '#app',
    router,
    store,
    components: { App },
    template: '<App/>'
})

module.exports = {
  commands: [],
  url: 'http://localhost:8080',
  elements: {
    docButton: {
      selector: '.button--green'
    },
    githubButton: {
      selector: '.button--grey'
    }
  }
}
