cmake_minimum_required(VERSION 3.22)
project(solution)

set(CMAKE_CXX_STANDARD 14)

# 在项目中运行多个 main 函数，以供 LeetCode（力扣）刷题需要
#add_executable(solution main.cpp Solution.cpp Solution.h)
file(GLOB_RECURSE files *.cpp)
foreach (file ${files})
    string(REGEX REPLACE ".+/(.+)\\..*" "\\1" exe ${file})
    add_executable(${exe} ${file})
    message(\ \ \ \ --\ src/${exe}.cpp\ will\ be\ compiled\ to\ bin/${exe})
endforeach ()

## ！！！！！ 注意 ！！！！！ ##
# 在项目中添加文件时，不应该勾选 "添加到目标" 选项
# 而应该在项目目录下 “右击”，手动 “重新加载 CMake 项目”