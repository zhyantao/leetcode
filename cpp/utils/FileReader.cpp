#include "FileReader.h"

vector<vector<int>> FileReader::getMatrix(string file_path) {
	vector<vector<int>> res;

	ifstream input_file(file_path);
	if (!input_file.is_open()) {
		cerr << "Cannot open file: " << file_path << endl;
		return res;
	}

	// 逐行读取文件内容
	cout << "\e[0;34m" << ">>>>>>> Get TestCase from " << file_path << "\033[0m" << endl;
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
	cout << "\e[0;34m" << ">>>>>>> End of TestCase : " << file_path << "\033[0m" << endl;

	input_file.close();
	return res;
}

vector<int> FileReader::getNumbers(string file_path) {
	vector<int> res;

	vector<vector<int>> matrix = FileReader::getMatrix(file_path);
	for (auto &t : matrix[0]) {
		res.push_back(t);
	}

	return res;
}
