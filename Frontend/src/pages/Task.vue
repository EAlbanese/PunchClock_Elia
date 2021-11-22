<template>
<q-page style="padding-top: ">
    <div class="LoginPage">
        <h1>Create new task</h1>
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
            <q-btn class="q-mt-xl" style="margin-right: 10px;" color="primary" label="Register" type="submit" @click="validateAndSubmit" />
            <q-btn class="q-mt-xl" color="dark" label="Back to Login" unelevated to="/" @click="goToLogin" />
        </div>
    </div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'

export default defineComponent({
    data() {
        return {
            checkin: "null"
        }
    },
    mounted() {
    }
}) 
</script>

<style>

</style>
