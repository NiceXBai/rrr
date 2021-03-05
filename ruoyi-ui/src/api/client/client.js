import request from '@/utils/request'

// 查看用户信息
export function userInfo(query) {
  return request({
    url: '/client/history/userinfo',
    method: 'get',

  })
}

// 查询识别记录列表
export function listHistory(query) {
  return request({
    url: '/client/history/userlist',
    method: 'get',
    params: query
  })
}



