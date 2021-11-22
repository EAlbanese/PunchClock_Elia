<template>
<q-page v-if="user">
  <div class="LoginPage">
    <h2 style="text-align:center; padding-top: 2px">Edit Account</h2>
      <div style="max-width: 300px;" class="q-mx-auto">
      <form  @submit="validateAndSubmit">
        <q-input v-model="user.firstname" type="text" class="form-control" label="First Name" />
        <q-input v-model="user.lastname" type="text" class="form-control" label="Last Name" />
        <q-input v-model="user.email" type="text" class="form-control" label="E-Mail" />
      </form>
      <div style="padding-top: 10px;">  
        <q-btn class="q-mt-xl" style="margin-right: 10px;" color="primary" label="Save" type="submit" @click="validateAndSubmit" />
        <q-btn class="q-mt-xl" color="dark" label="Back to User" unelevated to="/user" @click="goToUser" />
    </div>
    </div>
  </div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'
import { useStore } from 'vuex'
export default defineComponent({
    data() {
        return {
            checkin: "null",
            user:null,
            userold:[]
        }
    },
    computed: {
        id(){
            return this.$$route.params.id;
        }
    },
    mounted() {
        this.getUserById()
    },
    methods:{
      async getUserById(){
              console.log("test");
              let res = await axios.get("/user/"+this.GetJWTData().upn)
              this.user = res.data
              this.userold = res.data
          },
          GetJWTData() {
              const store = useStore()
              var token = null
              var jwt = store.getters["auth/JWT"]
              if (jwt !== null) {
                  var base64Url = jwt.split('.')[1]
                  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/')
                  token = JSON.parse(window.atob(base64))
              }
              return token;
          },
          async validateAndSubmit(){
            let res = await axios.put("/user",this.user)
            this.$router.push('/user')  
        }
    }
   
}) 
</script>

<style>

</style>
