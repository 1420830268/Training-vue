import request from '@/utils/request'

// 查询课程实体类列表
export function listCourse(query) {
  return request({
    url: '/course/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程实体类详细
export function getCourse(id) {
  return request({
    url: '/course/course/' + id,
    method: 'get'
  })
}

// 新增课程实体类
export function addCourse(data) {
  return request({
    url: '/course/course',
    method: 'post',
    data: data
  })
}

// 修改课程实体类
export function updateCourse(data) {
  return request({
    url: '/course/course',
    method: 'put',
    data: data
  })
}

// 删除课程实体类
export function delCourse(id) {
  return request({
    url: '/course/course/' + id,
    method: 'delete'
  })
}

// 导出课程实体类
export function exportCourse(query) {
  return request({
    url: '/course/course/export',
    method: 'get',
    params: query
  })
}