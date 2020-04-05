import request from '@/utils/request'

// 查询课程镜像列表
export function listImage(query) {
  return request({
    url: '/course/image/list',
    method: 'get',
    params: query
  })
}

// 查询课程镜像详细
export function getImage(id) {
  return request({
    url: '/course/image/' + id,
    method: 'get'
  })
}

// 新增课程镜像
export function addImage(data) {
  return request({
    url: '/course/image',
    method: 'post',
    data: data
  })
}

// 修改课程镜像
export function updateImage(data) {
  return request({
    url: '/course/image',
    method: 'put',
    data: data
  })
}

// 删除课程镜像
export function delImage(id) {
  return request({
    url: '/course/image/' + id,
    method: 'delete'
  })
}

// 导出课程镜像
export function exportImage(query) {
  return request({
    url: '/course/image/export',
    method: 'get',
    params: query
  })
}