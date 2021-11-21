module.exports = {
    devServer: {
        proxy: {
            '^/user': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            },
        }
    }
}