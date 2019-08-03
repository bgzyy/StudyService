#!/bin/bash

TOKEN=$(curl 'http://api.dev.devopseasy.com/oauth/oauth/token?client_id=client&client_secret=secret&grant_type=password&password=YWRtaW4%3D&username=admin' -X POST -H 'Accept: application/json, text/plain, */*' | jq -r '.access_token')
echo $TOKEN

# 根据 id 获取组织信息，并插入数据库
curl 'http://localhost:8080/study-24484/v1/organizations/1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"

# 根据组织 id 和用户 id 获取用户信息，并插入数据库
curl 'http://localhost:8080/study-24484/v1/organizations/1/users?page=1&size=20&id=1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"

# 分页获取 project 信息，../num/{pageNum}/size/{pageSize}
curl 'http://localhost:8080/study-24484/v1/projects/num/1/size/2' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"