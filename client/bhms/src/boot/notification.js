export default ({ app, router, Vue }) => {
  app.mixin({
    methods: {
      notifySuccess (message) {
        this.notify(message, 'positive')
      },
      notifyError (error) {
        if (typeof error === 'string') {
          this.notify(error, 'red')
        } else {
          let message = ''
          if (error && error.response && error.response.data) {
            message = error.response.data
          } else {
            message = JSON.stringify(error)
          }
          this.notify(message, 'red')
        }
      },
      notify (message, color) {
        this.$q.notify({
          color: color,
          position: 'top',
          message,
          actions: [
            {
              icon: 'clear',
              color: 'white',
              handler: () => {
              }
            }
          ]
        })
      }
    }
  })
}
