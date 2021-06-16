<template>
  <el-container>
    <el-header></el-header>
    <el-row>
      <el-form :inline="true">
        <el-form-item class="searchInput">
          <el-input v-model="input" placeholder="请输入关键词" size="small" style="width: 100%;"></el-input>
        </el-form-item>
        <el-form-item class="searchSelect">
          <el-select v-model="category" size="small">
            <el-option
                v-for="item in categoryList"
                :key="item.categoryId"
                :label="item.categoryDesignation"
                :value="item.categoryId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="searchSelect">
          <el-select v-model="secTime" size="small">
            <el-option
                v-for="item in secTimeList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" @click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="taskTable">
      <el-table :data="taskList" stripe border height="400">
        <el-table-column prop="id" label="序号"></el-table-column>
        <el-table-column prop="category" label="类别"></el-table-column>
        <el-table-column prop="title" label="标题"></el-table-column>
        <el-table-column prop="announcer" label="发布人"></el-table-column>
        <el-table-column prop="gmt_create" label="发布时间"></el-table-column>
        <el-table-column label="操作" width="200">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="viewDetail(scope.$index, scope.row)">查看详情</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
    <div class="page">
      <el-pagination
          @current-change="handleCurrentChange"
          @pre-click="handleCurrentChange"
          @next-click="handleCurrentChange"
          :current-page.sync="currentPage"
          :page-size="10"
          layout="total, prev, pager, next"
          :total="totalNum">
      </el-pagination>
    </div>
  </el-container>

</template>

<script>
import axios from "axios";
import qs from "qs";

export default {
  data () {
    return {
      currentPage: 1,
      totalNum: 53,
      input: '',
      category: '类别',
      categoryList: [
        { categoryDesignation: "衣服", categoryId: 1 },
      ],
      secTime: '发布时间',
      secTimeList: [
        {
          value: '0',
          label: '发布时间'
        }, {
          value: '1',
          label: '近三天'
        }, {
          value: '2',
          label: '近一天'
        }, {
          value: '3',
          label: '近七天'
        }, {
          value: '4',
          label: '近一个月'
        },{
          value: '5',
          label: '近三个月'
        }
      ],
      taskList: [ {
        "id":1,
        "pulisherId":11,          //发布者ID
        "title":"取快递",   //标题
        "category":1,            //类别
        "announcer":"zzzzcx",    //发布人
        "gmt_create":"2020-2-22",        //发布时间
    "pageInfo":
    {
      "currentPage":1,
        "totalNum":8,
        "totalPage":1
    }
  },
    {
      "id":2,
      "pulisherId":11,          //发布者ID
        "title":"取快递",   //标题
        "category":1,            //类别
        "announcer":"zzzzcx",    //发布人
        "gmt_create":"2020-2-22",        //发布时间
      "pageInfo":
      {
        "currentPage":1,
          "totalNum":8,
          "totalPage":1
      }
    }],//任务列表
    }
  },
  methods: {
    search() {
      let categoryId,days;
      if(this.category === "类别")
        categoryId = 0;
      else
        categoryId = this.category;
      if(this.secTime === "发布时间")
        days = 0;
      else
        days = this.secTime;
      axios.post("/api/admin/listTaskByKeyword",
          qs.stringify({
            days: days,
            categoryId: categoryId,
            keyWord: this.input,
            pageid: this.currentPage
          }),
      ).then(res => {
        this.taskList = res.data.data;
        this.currentPage = res.data.data[0].pageInfo.currentPage;
        this.totalNum = res.data.data[0].pageInfo.totalNum;
      })
    },//搜索

    viewDetail(index,row) {
      console.log(row.id);
      this.$router.push({name: "taskDetail", params: {'id': row.id}})
    },//查看详情

    handleDelete(index,row) {
      let url = "/api/myTask/deleteTaskById/" + row.id;
      axios.get(url);
      console.log("删除" + row.id);
    },//删除

    handleCurrentChange(val) {
      this.currentPage = val;
      this.search();
    },//改变页面
  },
  beforeMount:function () {
    axios.get("/api/task/listTaskCategory").then(res => {
      console.log(res);
      this.categoryList = res.data.data;
    })
    this.search();
  },
}
</script>

<style>
.searchInput {
  margin: 0 10%;
}
.searchSelect {
  margin: 0 10%;
}
.taskTable {
  margin: 20px 10%;
}
.page {
  margin: 0 auto;
}
</style>