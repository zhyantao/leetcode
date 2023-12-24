#ifndef TOOLS_HANDLER_H_
#define TOOLS_HANDLER_H_

#include <fstream>
#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

class Handler {
public:
	vector<vector<int>> handle_matrix(string file_path);
};

#endif /* TOOLS_HANDLER_H_ */
