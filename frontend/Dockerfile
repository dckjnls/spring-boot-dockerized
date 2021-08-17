### STEP 1: Build ###
FROM node:14-alpine
RUN mkdir -p /build
WORKDIR /build
COPY src .
COPY public .
COPY package.json .
COPY tsconfig.json .
COPY yarn.lock .
RUN yarn --frozen-lockfile
RUN yarn build

### STEP 2: Run ###