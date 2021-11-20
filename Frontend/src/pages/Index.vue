<template>
<q-page>
    <div class="LoginPage">
        <h1>Login</h1>
        <div style="max-width: 300px;" class="q-mx-auto">
            <form-wrapper :validator="$v">
                <form-group name="username">
                    <q-input v-model="username" label="E-Mail" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="password">
                    <q-input v-model="password" type="password" label="Password" slot-scope="{attrs}" v-bind="attrs" />
                </form-group>
            </form-wrapper>
        </div>
        <div style="padding-top: 10px;">
            <q-btn class="q-mt-xl" style="margin-right: 10px;" color="primary" unelevated to="/user" label="Login" @click="submitLogin" no-caps />
            <q-btn class="q-mt-xl" color="dark" label="Register" @click="goToRegister" />
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
            this.$v.$touch()
            if (this.$v.$invalid) {
                return
            }
            console.log("asd")
            let res = await axios.post('/User/Login', {
                Email: this.email,
                Password: this.password
            })
            if (res.status === 200) {
                const token = res.data.token
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
                $store.dispatch("auth/logout");
                $store.dispatch("auth/login", {
                    jwt: token
                });
                Notify.create({
                    position: 'top',
                    type: 'positive',
                    message: 'login sucssesd'
                })
                this.$router.push('/')
            }
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
