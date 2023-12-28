#ifndef UTILS_FILE_READER_H_
#define UTILS_FILE_READER_H_

#include <fstream>
#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

class FileReader {
public:
	vector<vector<int>> getMatrix(string file_path);
	vector<int> getNumbers(string file_path);
};

#endif /* UTILS_FILE_READER_H_ */
