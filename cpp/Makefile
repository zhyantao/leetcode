CURR_DIR := $(pwd)

TARGET := Solution
SRCS := $(wildcard *.cpp utils/*.cpp LeetCode/*.cpp)
OBJS := $(patsubst %.cpp, %.o, $(SRCS))

CXXFLAGS := -Iutils -ILeetCode
LDFLAGS := -Lutils -LLeetCode

.PHONY: all
all: $(TARGET)

$(TARGET): $(OBJS)
	$(CXX) -o $@ $^ $(LDFLAGS)

$(OBJS): %.o: %.cpp
	$(CXX) -o $@ -c $< $(CXXFLAGS)

.PHONY: solution
solution:
	@./Solution

.PHONY: clean
clean:
	rm $(TARGET) $(OBJS)
