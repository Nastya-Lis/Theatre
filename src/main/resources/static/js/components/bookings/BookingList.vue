<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="bookings"
        >
            <template v-slot:[`item.role`]="{ item }">{{ item.roles.map(role => role.name).join(", ") }}</template>

        </v-data-table>
    </div>
</template>

<script>

    export default {

        created() {
          var profile = null
          this.$resource("/profile/").get().then(result => {
            result.json().then(profileJSON => {
              this.$resource("/user/booking/"+profileJSON.id).get().then(result => {
                result.json().then(bookingJSON => bookingJSON.forEach(booking => {
                  this.$resource("/performances/"+booking.performance).get().then(result => {
                    result.json().then(performanceJSON => booking.performance = performanceJSON)
                  })
                  this.bookings.push(booking)

                }))
              })
            })
          })
        },
        data() {
            return {
                headers:  [
                    { text: 'ID', value: 'id' },
                    { text: 'amount', value: 'amount' },
                    { text: 'title', value: 'performance.name' },
                    { text: 'price', value: 'performance.price' },
                    { text: 'rating', value: 'performance.rating' },
                ],
                bookings: [],
            }
        },

    }
</script>

<style>

</style>