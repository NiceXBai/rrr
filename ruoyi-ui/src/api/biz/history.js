import request from '@/utils/request'

// 查询识别记录列表
export function listHistory(query) {
  return request({
    url: '/biz/history/list',
    method: 'get',
    params: query
  })
}

// 查询识别记录详细
export function getHistory(id) {
  return request({
    url: '/biz/history/' + id,
    method: 'get'
  })
}

// 新增识别记录
export function addHistory(data) {
  return request({
    url: '/biz/history',
    method: 'post',
    data: data
  })
}

// 修改识别记录
export function updateHistory(data) {
  return request({
    url: '/biz/history',
    method: 'put',
    data: data
  })
}

// 删除识别记录
export function delHistory(id) {
  return request({
    url: '/biz/history/' + id,
    method: 'delete'
  })
}

// 导出识别记录
export function exportHistory(query) {
  return request({
    url: '/biz/history/export',
    method: 'get',
    params: query
  })
}