<template>
<q-page>
   <h2 style="text-align:center; padding-top: 2px">Account</h2>
    <div style="padding-top 10px; padding-left: 10%; padding-right: 10%;">
        <div style="padding-left: 25%; padding-right: 25%; height: 50%;">
<q-card class="my-card" flat bordered>
      <q-img
        src="https://cdn.quasar.dev/img/parallax2.jpg"
      />

      <q-card-section>
        <div class="text-overline text-orange-9">Welcome</div>
        <div class="text-h5 q-mt-sm q-mb-xs">{{user.firstname}} {{user.lastname}}</div>
        <div class="text-h6 q-mt-sm q-mb-xs">{{user.email}}</div>
        <div class="text-caption text-grey">
          You can edit or delete your Account.
        </div>
      </q-card-section>

      <q-card-actions>
        <q-btn color="warning" label="Edit" unelevated to="/edit" @click="goToUserEdit" />
        <q-btn color="negative" label="Delete" @click="deleteUser" />
      </q-card-actions>

      <q-slide-transition>
        <div v-show="expanded">
          <q-separator />
          <q-card-section class="text-subitle2">
            {{ lorem }}
          </q-card-section>
        </div>
      </q-slide-transition>
    </q-card>
        </div>
        
    </div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'
import {
    useStore
} from 'vuex'
export default defineComponent({
    data() {
        return {
            checkin: "null",
            user:[]
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
        },
        GetJWTData() {
            const store = useStore()
            var token = null
            var jwt = this.$store.getters["auth/JWT"]
            if (jwt !== null) {
                var base64Url = jwt.split('.')[1]
                var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/')
                token = JSON.parse(window.atob(base64))
            }
            return token;
        },
        async deleteUser(){
            let res = await axios.delete("/user/" + this.GetJWTData().upn)
            this.user = null
            this.$router.push('/')  
        }
    }
   
}) 
</script>

<style>

</style>
