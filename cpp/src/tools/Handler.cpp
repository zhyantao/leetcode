#include "Handler.h"

vector<vector<int>> Handler::handle_matrix(string file_path) {
	vector<vector<int>> res;

	ifstream input_file(file_path);
	if (!input_file.is_open()) {
		cerr << "Cannot open file: " << file_path << endl;
		return res;
	}

	// 逐行读取文件内容
	cout << "Reading from file: " << file_path << endl;
	string line;
	while (getline(input_file, line)) {
		// 使用 istringstream 分割字符串
		istringstream ss(line);
		string token;
		vector<int> tokens;

		while (getline(ss, token, ' ')) {
			tokens.push_back(stoi(token));
		}

		cout << line << endl;
		res.push_back(tokens);
	}
	cout << "End of file: " << file_path << endl;

	input_file.close();
	return res;
}
