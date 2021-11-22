<template>
<q-page>
    <div class="LoginPage">
        <h1>Login</h1>
        <div style="max-width: 300px;" class="q-mx-auto">
            <form-wrapper>
                <form-group name="username">
                    <q-input v-model="email" label="E-Mail" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="password">
                    <q-input v-model="password" type="password" label="Password" slot-scope="{attrs}" v-bind="attrs" />
                </form-group>
            </form-wrapper>
        </div>
        <div style="padding-top: 10px;">
            <q-btn class="q-mt-xl" style="margin-right: 10px;" color="primary" label="Login" @click="submitLogin" no-caps />
            <q-btn class="q-mt-xl" color="dark" label="Register" unelevated to="/register" @click="goToRegister" />
        </div>
    </div>
    

</q-page>
</template>

<script>
import { required } from 'vuelidate/lib/validators'
import { Notify } from 'quasar'

export default {
    name: 'Loginpage',
    data() {
        return {
            email: "",
            password: "",
        }
    },
    /*
    TODO: Fixen der Valdiation
    validations: {
        password: {
            required
        },
        username: {
            required
        }
    },*/
    methods: {
        async submitLogin() {
            this.$store.dispatch("auth/logout");
            axios.defaults.headers.common["authorization"] = null;
            let res = await axios.post('/auth/Login', {
                email: this.email,
                password: this.password
            })
            if (res.status === 200) {
                const token = res.data
                if (token == undefined) {
                    Notify.create({
                        position: 'top',
                        type: 'negative',
                        message: 'login failed'
                    })
                    this.password = ''
                    this.$v.$reset()
                    return;
                }
                    dispatch("auth/logout");
                this.$store.dispatch("auth/login", {
                    jwt: token

                });
                Notify.create({
                    position: 'top',
                    type: 'positive',
                    message: 'login sucssesd'
                })
            }
            this.$router.push('/user')
        },
        goToUser(){
            this.$$router.push('/user')
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
