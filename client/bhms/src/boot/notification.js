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
          this.notify(JSON.stringify(error), 'red')
        }
      },
      notify (message, color) {
        this.$q.notify({
          color: color,
          position: 'top',
          message: message,
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
