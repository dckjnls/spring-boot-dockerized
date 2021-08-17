### STEP 1: Dependecies ###
FROM node:14-alpine as dependencies
RUN mkdir -p /dependencies
WORKDIR /dependencies
COPY package.json yarn.lock ./
RUN ["yarn", "install", "--pure-lockfile"]

### STEP 2: Build ###
FROM dependencies as build
RUN mkdir -p /build
WORKDIR /build
COPY src ./src
COPY public ./public
COPY --from=dependencies /dependencies/package.json /dependencies/yarn.lock ./
COPY --from=dependencies /dependencies/node_modules ./node_modules
COPY tsconfig.json ./
RUN ["npx", "browserslist@latest", "--update-db"]
RUN ["yarn", "build"]

### STEP 3: Run ###
FROM keymetrics/pm2:latest-alpine
RUN mkdir -p /app
WORKDIR /app
COPY --from=build /build/build ./build
COPY process.js .
EXPOSE 3000
ENTRYPOINT ["pm2", "start", "process.js", "--attach"]