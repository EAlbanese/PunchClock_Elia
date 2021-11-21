<template>
<q-page>
    <div class="LoginPage">
        <h1>Register</h1>
        <div style="max-width: 300px;" class="q-mx-auto">
            <form @submit="validateAndSubmit">
                <div v-if="errors.length">
                    <div class="alert alert-danger" v-bind:key="index" v-for="(error, index) in errors">
                        {{error}}
                    </div>
                </div>
                <q-input v-model="firstname" type="text" class="form-control" label="First Name" />
                <q-input v-model="lastname" type="text" class="form-control" label="Last Name" />
                <q-input v-model="email" type="text" class="form-control" label="E-Mail" />
                <q-input v-model="password" type="text" class="form-control" label="Password" />
            </form>
        </div>
        <div style="padding-top: 10px;">
            <q-btn class="q-mt-xl" style="margin-right: 10px;" color="primary" label="Register" type="submit" />
            <q-btn class="q-mt-xl" color="dark" label="Back to Login" unelevated to="/" @click="goToLogin" />
        </div>
    </div>
    

</q-page>
</template>

<script>
import { required } from 'vuelidate/lib/validators'
import { Notify } from 'quasar'


export default {
    name: 'Register',
    data() {
        return {
            firstname: "",
            lastname: "",
            email: "",
            password: "",
            errors: []
        }
    },
    computed: {
        id(){
            return this.$$route.params.id;
        }
    },
    methods: {
        refreshRegisterDetails(){
            
        }
    }
}
</script>

<style>
.LoginPage {
    text-align: center;
    position: fixed;
    top: 24%;
    right: 0%;
    width: 100%;
}
</style>
