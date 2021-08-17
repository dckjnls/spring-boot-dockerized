module.exports = {
    script: "serve",
    env: {
        PM2_SERVE_PATH: './build',
        PM2_SERVE_PORT: 3000,
        PM2_SERVE_SPA: 'true',
        PM2_SERVE_HOMEPAGE: 'index.html',
        REACT_APP_API_URL: process.env.API_URL || 'http://localhost:8080'
    }
}